package edu.analytics.rop.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "da_wells")
public class Well {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "well_id")
    private Long wellId;
    @Column(name = "field_name")
    private String fieldName;
    @Column(name = "pad_name")
    private String padName;
    @Column(name = "well_name")
    private String wellName;
    @Column(name = "pad_set")
    private String padSet;
    @Column(name = "well_construction")
    private String wellConstruction;
    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY,
            mappedBy = "well")
    private List<Section> sections;

    @Override
    public int hashCode() {
        int result = 0;
        String str = fieldName + wellName;
        str = str.replaceAll(" ", "");
        str = str.toUpperCase();
        char[] chArr = str.toCharArray();
        for (char c : chArr) {
            result += c;
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Well well = (Well) obj;
        if (this.hashCode() != well.hashCode())
            return false;
        return (fieldName != null && fieldName.equals(well.getFieldName())) &&
                (padName != null && padName.equals(well.getPadName())) &&
                (wellName != null && wellName.equals(well.getWellName()));
    }

    public Long getWellId() {
        return wellId;
    }

    public void setWellId(Long wellId) {
        this.wellId = wellId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
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

    public String getPadSet() {
        return padSet;
    }

    public void setPadSet(String padSet) {
        this.padSet = padSet;
    }

    public String getWellConstruction() {
        return wellConstruction;
    }

    public void setWellConstruction(String wellConstruction) {
        this.wellConstruction = wellConstruction;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
