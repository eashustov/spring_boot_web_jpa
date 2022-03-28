package ru.sberbank.spring_boot_web_jpa.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberbank.spring_boot_web_jpa.dao.Mq_tivoli_repo;
import ru.sberbank.spring_boot_web_jpa.dao.Usp_mq_data_repo;
import ru.sberbank.spring_boot_web_jpa.domain.mq_tivoli_data;
import ru.sberbank.spring_boot_web_jpa.domain.usp_mq_data;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Logger;

@Service
public class CsvExportService {

    private static final Logger log = Logger.getLogger(String.valueOf(CsvExportService.class));

    @Autowired
    ru.sberbank.spring_boot_web_jpa.dao.Mq_tivoli_repo mqTivoliRepo;
    @Autowired
    ru.sberbank.spring_boot_web_jpa.dao.Usp_mq_data_repo uspMqDataRepo;


//    public CsvExportService(Mq_tivoli_repo mqTivoliRepo, Usp_mq_data_repo uspMqDataRepo ) {
//        this.mqTivoliRepo = mqTivoliReptho;
//
//    }

    public void mqTivoliWriteEmployeesToCsv(Writer writer) {

        Iterable<mq_tivoli_data> mqTivoliDataList  = mqTivoliRepo.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withQuote(null)
                .withAllowMissingColumnNames(true).withTrailingDelimiter(true)
                .withSkipHeaderRecord(false).withIgnoreEmptyLines(true).withHeader("ID", "Server Name", "MQ Name", "Tivoli Status"))) {

            for (mq_tivoli_data mqTivoliData : mqTivoliDataList) {
                csvPrinter.printRecord(mqTivoliData.getId(), mqTivoliData.getServerName(), mqTivoliData.getMqName(), mqTivoliData.getTivoliInstall());
            }
        } catch (IOException e) {
            log.throwing("CsvExportService.class", "writeEmployeesToCsv", e);
        }
    }

    public void uspTivoliWriteEmployeesToCsv(Writer writer) {

        Iterable<usp_mq_data> uspMqDataList  = uspMqDataRepo.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withQuote(null)
                .withAllowMissingColumnNames(true).withTrailingDelimiter(true)
                .withSkipHeaderRecord(false).withIgnoreEmptyLines(true).withHeader("Сервер", "MQ версия", "MQ менеджер", "MQ статус", "Tivoli версия",
                        "Tivoli статус", "Дата", "Стенд"))) {

            for (usp_mq_data uspMqData : uspMqDataList) {
                csvPrinter.printRecord(uspMqData.getHost(), uspMqData.getMqVersion(), uspMqData.getMqName(), uspMqData.getMqStatus(), uspMqData.getTivoliVersion(), uspMqData.getTivoliStatus(), uspMqData.getDateCapture(), uspMqData.getStand());
            }
        } catch (IOException e) {
            log.throwing("CsvExportService.class", "writeEmployeesToCsv", e);
        }
    }
}
