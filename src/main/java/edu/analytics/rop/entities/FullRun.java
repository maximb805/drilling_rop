package edu.analytics.rop.entities;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "da_full_runs")
public class FullRun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "full_run_id")
    private Long fullRunId;
    @Column(name = "full_run_num")
    private int runNum;
    @Column(name = "full_run_start_date")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate startDate;
    @Column(name = "full_run_bit_type")
    private String bitFullType;
    @Column(name = "full_run_bit_IADC")
    private String bitIADCCode;
    @Column(name = "full_run_bit_serial")
    private String bitSerial;
    @Column(name = "full_run_start_depth")
    private double runStartDepth;
    @Column(name = "full_run_end_depth")
    private double runEndDepth;
    @Column(name = "full_run_penetration")
    private double runPenetration;
    @Column(name = "full_run_drilling_time")
    private double runDrillingTime;
    @Column(name = "full_run_ROP")
    private double runROP;
    @Column(name = "full_run_bit_diameter")
    private double diameter;
    @Column(name = "full_run_pad_name")
    private String padName;
    @Column(name = "full_run_well_name")
    private String wellName;
    @Column(name = "full_run_purpose")
    private String runPurpose;
    @Column(name = "full_run_well_construction")
    private String wellConstruction;
    @Column(name = "full_run_bit_producer")
    private String bitProducer;
    @Column(name = "full_run_pad_set")
    private String padSet;
    @Column(name = "full_run_field_name")
    private String fieldName;

    public Long getFullRunId() {
        return fullRunId;
    }

    public void setFullRunId(Long fullRunId) {
        this.fullRunId = fullRunId;
    }

    public int getRunNum() {
        return runNum;
    }

    public void setRunNum(int runNum) {
        this.runNum = runNum;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getBitFullType() {
        return bitFullType;
    }

    public void setBitFullType(String bitFullType) {
        this.bitFullType = bitFullType;
    }

    public String getBitIADCCode() {
        return bitIADCCode;
    }

    public void setBitIADCCode(String bitIADCCode) {
        this.bitIADCCode = bitIADCCode;
    }

    public String getBitSerial() {
        return bitSerial;
    }

    public void setBitSerial(String bitSerial) {
        this.bitSerial = bitSerial;
    }

    public double getRunStartDepth() {
        return runStartDepth;
    }

    public void setRunStartDepth(double runStartDepth) {
        this.runStartDepth = runStartDepth;
    }

    public double getRunEndDepth() {
        return runEndDepth;
    }

    public void setRunEndDepth(double runEndDepth) {
        this.runEndDepth = runEndDepth;
    }

    public double getRunPenetration() {
        return runPenetration;
    }

    public void setRunPenetration(double runPenetration) {
        this.runPenetration = runPenetration;
    }

    public double getRunDrillingTime() {
        return runDrillingTime;
    }

    public void setRunDrillingTime(double runDrillingTime) {
        this.runDrillingTime = runDrillingTime;
    }

    public double getRunROP() {
        return runROP;
    }

    public void setRunROP(double runROP) {
        this.runROP = runROP;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public String getPadName() {
        return padName;
    }

    public void setPadName(String padName) {
        this.padName = padName;
    }

    public String getWellName() {
        return wellName;
    }

    public void setWellName(String wellName) {
        this.wellName = wellName;
    }

    public String getRunPurpose() {
        return runPurpose;
    }

    public void setRunPurpose(String runPurpose) {
        this.runPurpose = runPurpose;
    }

    public String getWellConstruction() {
        return wellConstruction;
    }

    public void setWellConstruction(String wellConstruction) {
        this.wellConstruction = wellConstruction;
    }

    public String getBitProducer() {
        return bitProducer;
    }

    public void setBitProducer(String bitProducer) {
        this.bitProducer = bitProducer;
    }

    public String getPadSet() {
        return padSet;
    }

    public void setPadSet(String padSet) {
        this.padSet = padSet;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
