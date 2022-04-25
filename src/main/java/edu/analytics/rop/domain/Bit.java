package edu.analytics.rop.domain;

import javax.persistence.*;

@Entity
@Table(name = "da_bits")
public class Bit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bit_id")
    private Long bitId;
    @Column(name = "bit_serial")
    private String bitSerial;
    @Column(name = "bit_short_type")
    private String bitShortType;
    @Column(name = "bit_full_type")
    private String bitFullType;
    @Column(name = "bit_IADC_code")
    private String IADCCode;
    @Column(name = "bit_diameter")
    private double diameter;

    public String getBitSerial() {
        return bitSerial;
    }

    public void setBitSerial(String bitSerial) {
        this.bitSerial = bitSerial;
    }

    public String getBitShortType() {
        return bitShortType;
    }

    public void setBitShortType(String bitShortType) {
        this.bitShortType = bitShortType;
    }

    public String getBitFullType() {
        return bitFullType;
    }

    public void setBitFullType(String bitFullType) {
        this.bitFullType = bitFullType;
    }

    public String getIADCCode() {
        return IADCCode;
    }

    public void setIADCCode(String IADCCode) {
        this.IADCCode = IADCCode;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }
}
