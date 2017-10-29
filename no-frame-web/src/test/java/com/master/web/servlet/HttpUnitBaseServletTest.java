package com.master.web.servlet;

import com.meterware.httpunit.*;
import org.junit.Test;

/**
 * need to start the web app before starting to run the HttpUnit testcases
 */
public class HttpUnitBaseServletTest {

    @Test
    public void loadAllArticle() throws Exception {
        WebConversation wc = new WebConversation();
        WebRequest req = new GetMethodWebRequest("http://localhost:8080/no-frame-web/base");
        req.setParameter("method", "loadAllArticle");
        WebResponse resp = wc.getResponse(req);

        System.out.println(resp.getText());
    }

    @Test
    public void getHtmlContent() throws Exception {
        WebConversation wc = new WebConversation();
        WebResponse wr = wc.getResponse("http://localhost:8080/no-frame-web/base?method=loadAllArticle");
        System.out.println(wr.getText());

    }

    @Test
    public void postLoadAllArticle() throws Exception {
        WebConversation wc = new WebConversation();
        WebRequest req = new PostMethodWebRequest("http://localhost:8080/no-frame-web/base?method=postLoadAllArticle");
        req.setParameter("name", "lily1");
        WebResponse resp = wc.getResponse(req);
        System.out.println(resp.getText());

    }

    @Test
    public void tableContent() throws Exception {
        System.out.println("获取页面中表格的内容：");
        // 建立一个WebConversation实例
        WebConversation wc = new WebConversation();
        // 获取响应对象
        WebResponse resp = wc.getResponse("http://www.w3school.com.cn/tiy/loadtext.asp?f=html_table_test");

        System.out.println(resp.getText());
        // 获得对应的表格对象
        WebTable webTable = resp.getTables()[0];
        // 将表格对象的内容传递给字符串数组
        String[][] datas = webTable.asText();
        // 循环显示表格内容
        int i = 0, j = 0;
        int m = datas[0].length;
        int n = datas.length;
        while (i < n) {
            j = 0;
            while (j < m) {
                System.out.println("表格中第" + (i + 1) + "行第" + (j + 1) + "列的内容是："
                        + datas[i][j]);
                ++j;
            }
            ++i;
        }
    }

}