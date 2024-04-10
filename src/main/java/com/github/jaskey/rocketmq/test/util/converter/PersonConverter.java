package com.github.jaskey.rocketmq.test.util.converter;

import com.github.jaskey.rocketmq.test.util.po.CatPO;
import com.github.jaskey.rocketmq.test.util.po.PersonPO;
import com.github.jaskey.rocketmq.test.util.vo.CatVO;
import com.github.jaskey.rocketmq.test.util.vo.PersonVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonConverter {

    private static Logger logger = LoggerFactory.getLogger(PersonConverter.class);

    public static PersonVO converterPersonPO(PersonPO po) {
        PersonVO personVO = new PersonVO();
        personVO.setId(po.getId());
        personVO.setName(po.getName());
        personVO.setAge(po.getAge());
        return personVO;
    }

    public static CatVO converterCatVo(CatPO catPO) {
        CatVO catVO = new CatVO();
        catVO.setAge(catPO.getAge());
        catVO.setName(catPO.getName());
        return catVO;
    }

    public static void main(String[] args) {
        try {



            String urlStr = "https://img.sobot.com/console/ecdcd58984fa44888c4f59b89d4bb6f9/smsSign/2c1c9c201128.jpg?appId=test";


            URL urlConet = new URL(urlEncodeChinese(urlStr));
            HttpURLConnection con = (HttpURLConnection) urlConet.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(4 * 1000);
            InputStream inStream = con.getInputStream();    //通过输入流获取图片数据
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            inStream.close();
            byte[] data = outStream.toByteArray();

            FileOutputStream outputStream = new FileOutputStream("/Users/mac/Downloads/downloaded_image.jpg");
            outputStream.write(data);
            outStream.close();

            System.out.println(new String(data));
        } catch (Exception e) {
            logger.warn("get file image by url error " + e.getMessage(), e);
        }


    }

    private static final Pattern CHINESE_PATTERN = Pattern.compile("[\\u4e00-\\u9fa5]");
    private static String urlEncodeChinese(String urlStr) {
        Matcher matcher = CHINESE_PATTERN.matcher(urlStr);
        if (!matcher.find()) {
            return urlStr;
        }
        try {
            URL url = new URL(urlStr);
            URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
            return uri.toASCIIString();
        } catch (Exception e) {
            logger.error("Parsing url exception : {}", urlStr, e);
        }
        return urlStr;
    }

    public static Boolean getResult (int i) {
        if (i == 0) {
            return true;
        }

        return false;
    }
}
