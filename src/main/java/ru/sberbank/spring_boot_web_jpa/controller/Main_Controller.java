package ru.sberbank.spring_boot_web_jpa.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sberbank.spring_boot_web_jpa.dao.Mq_tivoli_repo;
import ru.sberbank.spring_boot_web_jpa.dao.Usp_mq_data_repo;
import ru.sberbank.spring_boot_web_jpa.domain.mq_tivoli_data;
import ru.sberbank.spring_boot_web_jpa.domain.usp_mq_data;
import ru.sberbank.spring_boot_web_jpa.service.CsvExportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class Main_Controller {
    @Autowired
    Mq_tivoli_repo mq_tivoli_repo;
    @Autowired
    Usp_mq_data_repo usp_mq_data_repo;
    @Autowired
    CsvExportService csvExportService;


    @GetMapping("/mq_tivoli_report")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "mq_tivoli_report";
//    }
    public String mq_tivoli_report(Map<String, Object> model) {
        Iterable<mq_tivoli_data> mq_tivoli_list = mq_tivoli_repo.findAll();
        model.put("mq_tivoli_list", mq_tivoli_list);
        return "mq_tivoli_report";
    }

    @GetMapping("/usp_mq_tivoli_report")
    public String usp_mq_tivoli_report(String mqVersion, Map<String, Object> model) {
        Iterable<usp_mq_data> usp_mq_data_list = usp_mq_data_repo.findAll();
        model.put("usp_mq_data_list", usp_mq_data_list);
        return "usp_mq_tivoli_report";
    }

    @GetMapping(path = "/export")
    public void getMQTivoliReportInCsv(HttpServletResponse servletResponse, HttpServletRequest request) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"mq_tivoli_report.csv\"");
        String referer = request.getHeader("referer");
        if (referer.contains("/usp_mq_tivoli_report")) {
            csvExportService.uspTivoliWriteEmployeesToCsv(servletResponse.getWriter());
        }
        else if (referer.contains("/mq_tivoli_report")) {
            csvExportService.mqTivoliWriteEmployeesToCsv(servletResponse.getWriter());
        }

    }

}