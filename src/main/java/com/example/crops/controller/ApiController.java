package com.example.crops.controller;

import com.example.crops.domain.NewsVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


@Controller
@Log4j2
@AllArgsConstructor
@RequestMapping("/news/*")
public class ApiController {

    @GetMapping("/apitest")
    public void getdata(Model model, String search, Integer a) throws IOException {

        String text = null;
//
        List<NewsVO> newsList = new ArrayList<>();

        try {
            text = URLEncoder.encode(search, "UTF-8");
            String apiURL = "https://search.daum.net/nate?w=news&nil_search=btn&DA=NTB&enc=utf8&cluster=y&cluster_page=1&q=" + text + "&p=" + a;

            Document doc = Jsoup.connect(apiURL).get();
            Elements liElements = doc.select("ul.list_news"); // Select all <li> elements
            System.out.println(liElements);
            for (Element liElement : liElements) {
                Elements li_lists =liElement.select("li");
                for (Element li_list : li_lists){
                    NewsVO newsVO = new NewsVO();
                    String imgurl = li_list.select("img").attr("data-original-src");
                    System.out.println("imgurl: "+imgurl);
                    newsVO.setImgurl(imgurl);


                    newsVO.setLink(imgurl);
                    Elements des_tags = li_list.select("div.wrap_cont");
                    for (Element des_tag : des_tags){
                        String title = li_list.select("a.tit_main.fn_tit_u").text();
                        String link = li_list.select("a.tit_main.fn_tit_u").attr("href");
                        String description = des_tag.select("p.desc").text();
                        String newspaper = des_tag.select("span.cont_info").select("a.f_nb").text();
                        String pubDate = des_tag.select("span.cont_info").select("span.f_nb").text();
                        newsVO.setTitle(title);
                        newsVO.setLink(link);
                        newsVO.setDescription(description);

                        newsVO.setNewspaper(newspaper);
                        newsVO.setPubDate(pubDate);
                        System.out.println("title: " +title);
                        System.out.println("link: " + link);
                        System.out.println("description: "+description);

                        System.out.println("newspaper: "+ newspaper);
                        System.out.println("pubDate: "+pubDate);
                    }


//
//
//
//

                    newsList.add(newsVO);
                }

            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패", e);
        }

        model.addAttribute("news", newsList);

    }

}