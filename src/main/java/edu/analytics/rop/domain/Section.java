package edu.analytics.rop.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "da_sections")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "section_id")
    private Long sectionId;
    @Column(name = "section_start_date")
    private LocalDate sectionStartDate;
    @Column(name = "section_start_depth")
    private double sectionStartDepth;
    @Column(name = "section_end_depth")
    private double sectionEndDepth;
    @Column(name = "section_penetration")
    private double sectionPenetration;
    @Column(name = "section_drilling_time")
    private double sectionDrillingTime;
    @Column(name = "section_rop")
    private double sectionROP;
    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY,
            mappedBy = "section")
    private List<Run> runs;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "well_id")
    private Well well;

    public LocalDate getSectionStartDate() {
        return sectionStartDate;
    }

    public void setSectionStartDate(LocalDate sectionStartDate) {
        this.sectionStartDate = sectionStartDate;
    }

    public double getSectionStartDepth() {
        return sectionStartDepth;
    }

    public void setSectionStartDepth(double sectionStartDepth) {
        this.sectionStartDepth = sectionStartDepth;
    }

    public double getSectionEndDepth() {
        return sectionEndDepth;
    }

    public void setSectionEndDepth(double sectionEndDepth) {
        this.sectionEndDepth = sectionEndDepth;
    }

    public double getSectionPenetration() {
        return sectionPenetration;
    }

    public void setSectionPenetration(double sectionPenetration) {
        this.sectionPenetration = sectionPenetration;
    }

    public double getSectionDrillingTime() {
        return sectionDrillingTime;
    }

    public void setSectionDrillingTime(double sectionDrillingTime) {
        this.sectionDrillingTime = sectionDrillingTime;
    }

    public double getSectionROP() {
        return sectionROP;
    }

    public void setSectionROP(double sectionROP) {
        this.sectionROP = sectionROP;
    }

    public List<Run> getRuns() {
        return runs;
    }

    public void setRuns(List<Run> runs) {
        this.runs = runs;
    }

    public Well getWell() {
        return well;
    }

    public void setWell(Well well) {
        this.well = well;
    }
}
