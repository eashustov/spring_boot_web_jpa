package ru.sberbank.spring_boot_web_jpa.domain;
import javax.persistence.*;

@Entity
@Table(name = "TESTMQTIVOLI")
public class mq_tivoli_data {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name = "SERVERNAME")
    private String serverName;
    @Column(name = "MQNAME")
    private String mqName;
    private String tivoliInstall;

    public mq_tivoli_data(String serverName, String mqName, String tivoliInstall, String test) {
        this.serverName = serverName;
        this.mqName = mqName;
        this.tivoliInstall = tivoliInstall;

    }

    public mq_tivoli_data() {
    }

    public Long getId() {
        return id;
    }

    public String getServerName() {
        return serverName;
    }

    public String getMqName() {
        return mqName;
    }

    public String getTivoliInstall() {
        return tivoliInstall;
    }


}
