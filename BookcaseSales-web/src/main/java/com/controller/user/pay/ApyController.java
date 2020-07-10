package com.controller.user.pay;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.entity.Order;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: AplyDemo
 * @description:
 * @author: admin
 * @create: 2019-12-17 11:46
 **/
@Controller
public class ApyController {
    //private final String APP_ID = "2016101600702344";
    private final String APP_ID = "2016102100731941";
    private final String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCAs1HTObv6bXpzkXzGOe/BZ4efErJggJ9oJGQS6+DG3F64XJr/vJA7P/X4Ztk6FThOcbeKrNoNDb4qRGtULd/wFibRM53uwOngLqiA/+AAFLJZgYOzjNNF5RS2o2txahUtRwb3qSPUFro0AOs31vSEZOlg7jAu7pipMwePTG7rZZ/pgn31VjqV1iJ6AQxR5kcZm9ky57n2iCv+HOSpOMQqfD+hcEqIsP2OAN7g54Jzeu9ph1s1MEE1hO3WBdNkfvZxISTB5z8IBhMEsYswHi2Otg7SylQN8V83dQDJ8M0dtt7ZaMZg9QCG17kHE7iIlg4HqgIV2vDNKmnLZcUuTCxXAgMBAAECggEAWbGfcyAne85UqrpYRSYXi6iFgj1bh5ncfo3uGKm/S5hFgyM2+sgFlOVsnSPAfJRRW4oxKjpw9OwA/iAU1OPrz70AbIgWp1BXLmAWG2E4UZYa/fofOUEJ9QpEN00JEk+mVpnLp0p/p833E0sYox/x5VsWsvENL4glaLYhrKLOIssAmE5j/zw3x64nzjd1QEC4sr3untMGvE6iMf2fR0WkETlkY1w16IO45DiS8rkmmpDrIFCTuLoho2EfrP1mrnWoKr9YvnVLAmwCZ0W47baZt9zchrcxuSnhCuGuZtYhY2ndxUUzV1e1r3Scle1h3cxs3yljLYo5fwHwNpBvqMq3oQKBgQDFQAaqo/SA3uMA1Sob0yTkKzwChRDbt/0DcRngJpOIQt/nf8qhiOb5/1wWrYFlUGRjnQMDUiZRjRAp1Sj1svcXC1QayFf/ZO0RyQy8aI3UYw9XngQ97R/BlE4CH4CVOQ113kEBsUjrE4MlM3OhNGunIlNvXHYDOVh0YYMtteIeTwKBgQCnCIEahm/YHcz8sa3V9oWcK/r25zmEfZSMqapOhi6/0Vb372xqV9VlLzHOlUhx7h/DKFa4CbPXnZbnrwwJ/AebD1pjHeyYokjsI9gxVCkqIZqbVzwIyVPzrhmudMjumwc66c7nd6lo+uDp54AqowOoJp+AsYoa+1L6PgRpHzFXeQKBgEV31CE61vygAuCjMk5UYXS+SUc16AcJ2GDi71MDIwhlTQfx+MJFPduj9KHD/4NX+dMfVBVSVE56WMvy15cYrW7/PWKlVmCLAfc2kHa2d+Tp8lhQPXw1y+5YNdUHlTh4vGXbnZdkAaNQ3uo2Ia4PkS5up2Xb8XAXPTDXuuRZX0Z/AoGBAJPUMP7a0I3DAjL6xdFB10o6mmh+iCc8RYagenv4wdM+YOwZ2CfeCJz+weQFtxIuH6pHP0iuPZ6seGwgPlVv2wNe+S4Tw9vqdQOZTbOKusvw5bZp5FYaaNSX117ROSwDxMhdOaMeAq9IqloZaxNRJuFhHXV2q7XpjKywypKG6tJxAoGAIb7xMZOIqN7RJY+qfbUWUd/5RRYF7pZvdeBes3iLEqoa+JcAVu9CE1L7+/izN25GqFipzq+/R6nQCGFWth4ryeDUWcGI7z4zck4O0ntic8nQcZB7Bfhcxos/OpP08eQ90REoCv+NCm8KTwAcXxUsJW/G2Auaa2+rIzcpYBCbgdc=";
    private final String CHARSET = "UTF-8";
    //这个是支付宝公匙，不是应用公匙！！！
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAt/bcgiLLPYRLScII1r0qFgX0XrAnx+kyBSdrhBNB7U8ozLWk5CK97pKIQ1UQKgI/pK2Opiga8jNBRtg+5sU3AfBzXDnv9YJHXx2OivvckDntB8kqYfVW9jPZtTAVeF9V93s+qPjEcGPr5Qh/Hj3CCmXS9kaubsuXy8hjjXK5UsgnFpmmNfPpAS3H5NbWr0tn+SY596Ks3kYM2xpIcMJaJw24hh5Pcu+SfvOJW759bEBpPrpneTJrJ+/BvXA5UfXsndDXztYFGiF2OB/ySETWqDKVGgVz+rD/9cqFRQzviSBEMDa2ewVi9t4UqGjEbs/7TZ67r44mP7Y0OX5kV1BviwIDAQAB";
    //这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
    //private final String GATEWAY_URL ="https://openapi.alipaydev.com/gateway.do";
    private final String GATEWAY_URL = "https://openapi.alipaydev.com/gateway.do";

    private final String FORMAT = "JSON";
    //签名方式
    private final String SIGN_TYPE = "RSA2";
    //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
    private final String NOTIFY_URL = "http://localhost:8080/notifyUrl";
    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
    private final String RETURN_URL = "http://localhost:8080/returnUrl";

    @Autowired
    private OrderService orderService;

    @RequestMapping("/toPay")
    public void alipay(@RequestParam(value = "totalMoney",required = false) String totalMoney,
                       @RequestParam(value = "orderId",required = false) int orderId,
                       HttpServletRequest httpServletRequest,HttpServletResponse httpResponse) throws IOException {
        orderService.updateOrder(orderId,1,new Date());
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(RETURN_URL);
        request.setNotifyUrl(NOTIFY_URL);
        //根据订单编号,查询订单相关信息
        //商户订单号，商户网站订单系统中唯一订单号，必填
        //String out_trade_no = "24433222339";
        //我的订单信息
       Order order = orderService.getOrderByOrderIdm(orderId);
        System.out.println("------------------------" + order);
        System.out.println("我的订单编号：-----------------" + order.getOrderSnid());
        //System.out.println("我的订单名称：-----------------" + order.getOrderDetails().get(3));
        String out_trade_no = order.getOrderSnid();
        //付款金额，必填
        String total_amount = totalMoney;

        //订单名称，必填
        String subject = "订单描述";
        //商品描述，可空
        String body = "";
        request.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    @RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
    public String returnUrl(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
        System.out.println("=================================同步回调=====================================");
        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = (Map<String, String[]>) request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            /**valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");*/
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);/*查看参数都有哪些*/
       boolean signVerified = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE); // 调用SDK验证签名
//验证签名通过
        System.out.println("signVerified = " + signVerified);
        if (signVerified) {
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("商户订单号=" + out_trade_no);
            System.out.println("支付宝交易号=" + trade_no);
            System.out.println("付款金额=" + total_amount);

            //支付成功，修复支付状态
            return "redirect:/pfaile";//跳转付款成功页面
        } else {
            return "redirect:/psuccess";//跳转付款失败页面
        }
    }

    /**
     * 支付成功，进行一些订单信息的管理，最后进入成功界面
     * @return
     */
    @RequestMapping("/psuccess")
    public String ok(){
        return "user/userIndex";
    }

    /**
     * 支付失败，返回失败界面
     * @return
     */
    @RequestMapping("/pfaile")
    public String no(){
        return "user/pay/payFailed";
    }
}
