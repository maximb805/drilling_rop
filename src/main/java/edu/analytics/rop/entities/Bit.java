package edu.analytics.rop.entities;

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
    private String bitIADCCode;
    @Column(name = "bit_producer")
    private String bitProducer;
    @Column(name = "bit_diameter")
    private double diameter;

    @Override
    public int hashCode() {
        int result = 0;
        String str = bitSerial + bitProducer;
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
        Bit bit = (Bit) obj;
        if (this.hashCode() != bit.hashCode())
            return false;
        return (bitSerial != null && bitSerial.equals(bit.getBitSerial())) &&
                (bitProducer != null && bitProducer.equals(bit.getBitProducer())) &&
                (bitFullType != null && bitFullType.equals(bit.getBitFullType())) &&
                (bitIADCCode != null && bitIADCCode.equals(bit.getBitIADCCode())) &&
                (diameter != 0.0 && diameter == bit.getDiameter());
    }

    public Long getBitId() {
        return bitId;
    }

    public void setBitId(Long bitId) {
        this.bitId = bitId;
    }

    public String getBitProducer() {
        return bitProducer;
    }

    public void setBitProducer(String bitProducer) {
        this.bitProducer = bitProducer;
    }

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

    public String getBitIADCCode() {
        return bitIADCCode;
    }

    public void setBitIADCCode(String bitIADCCode) {
        this.bitIADCCode = bitIADCCode;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }
}
