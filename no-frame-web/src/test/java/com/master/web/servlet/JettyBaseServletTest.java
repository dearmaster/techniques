package com.master.web.servlet;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.jetty.servlet.ServletHandler;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JettyBaseServletTest {

    private static Server server;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        server = new Server();
        Connector connector=new SocketConnector();
        connector.setPort(8080);
        server.setConnectors(new Connector[]{connector});
        ServletHandler handler=new ServletHandler();
        server.setHandler(handler);
        handler.addServletWithMapping("com.master.web.servlet.BaseServlet", "/no-frame-web/base");
        server.start();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        //server.stop();
    }

    /**
     * jetty + httpunit
     */
    @Test
    public void loadAllArticle() throws Exception {
        try {
            WebConversation wc = new WebConversation();
            WebResponse web = wc.getResponse("http://localhost:8080/no-frame-web/base?method=loadAllArticle");
            String result=web.getText();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * jetty + httpclient
     */
    @Test
    public void postLoadAllArticle() throws Exception {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpPost method = new HttpPost("http://localhost:8080/no-frame-web/base?method=postLoadAllArticle");

        List<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("name", "lily"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"utf-8");
        method.setEntity(entity);

        HttpResponse response;
        try {
            response = httpclient.execute(method);

            HttpEntity resEntity = response.getEntity();

            System.out.println(resEntity);
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
        } catch (ClientProtocolException e1) {
            e1.printStackTrace();
            Assert.fail();
        } catch (IOException e1) {
            e1.printStackTrace();
            Assert.fail();
        }
    }

}