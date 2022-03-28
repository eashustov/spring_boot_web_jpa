package ru.sberbank.spring_boot_web_jpa.domain;
import javax.persistence.*;

@Entity
@IdClass (usp_mq_data_id.class)
public class usp_mq_data {
    @Id
    private String host;
    private String mqVersion;
    @Id
    private String mqName;
    private String mqStatus;
    private String tivoli;
    private String tivoliVersion;
    private String tivoliStatus;
    private String dateCapture;
    private String stand;

    public usp_mq_data() {
    }

    public usp_mq_data(String host, String mqVersion, String mqName, String mqStatus, String tivoli, String tivoliVersion, String tivoliStatus, String dateCapture, String stand) {
        this.host = host;
        this.mqVersion = mqVersion;
        this.mqName = mqName;
        this.mqStatus = mqStatus;
        this.tivoli = tivoli;
        this.tivoliVersion = tivoliVersion;
        this.tivoliStatus = tivoliStatus;
        this.dateCapture = dateCapture;
        this.stand = stand;
    }

    public String getHost() {
        return host;
    }

    public String getMqVersion() {
        return mqVersion;
    }

    public String getMqName() {
        return mqName;
    }

    public String getMqStatus() {
        return mqStatus;
    }

    public String getTivoli() {
        return tivoli;
    }

    public String getTivoliVersion() {
        return tivoliVersion;
    }

    public String getTivoliStatus() {
        return tivoliStatus;
    }

    public String getDateCapture() {
        return dateCapture;
    }

    public String getStand() {
        return stand;
    }

}
