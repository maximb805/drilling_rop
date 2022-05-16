package edu.analytics.rop.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "da_runs")
public class Run {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "run_id")
    private Long runId;
    @Column(name = "run_num")
    private int runNum;
    @Column(name = "run_start_date")
    @JsonFormat(pattern = "dd.MM.yyyy")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate runStartDate;
//    @Column(name = "run_diameter")
//    private double runDiameter;
    @Column(name = "run_start_depth")
    private double runStartDepth;
    @Column(name = "run_end_depth")
    private double runEndDepth;
    @Column(name = "run_penetration")
    private double runPenetration;
    @Column(name = "run_drilling_time")
    private double runDrillingTime;
    @Column(name = "run_rop")
    private double runROP;
    @Column(name = "run_purpose")
    private String runPurpose;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "bit_id")
    private Bit bit;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id")
    private Section section;

    public Long getRunId() {
        return runId;
    }

    public void setRunId(Long runId) {
        this.runId = runId;
    }

    public int getRunNum() {
        return runNum;
    }

    public void setRunNum(int runNum) {
        this.runNum = runNum;
    }

    public LocalDate getRunStartDate() {
        return runStartDate;
    }

    public void setRunStartDate(LocalDate runStartDate) {
        this.runStartDate = runStartDate;
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

    public String getRunPurpose() {
        return runPurpose;
    }

    public void setRunPurpose(String runPurpose) {
        this.runPurpose = runPurpose;
    }

    public Bit getBit() {
        return bit;
    }

    public void setBit(Bit bit) {
        this.bit = bit;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
