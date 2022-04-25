package edu.analytics.rop.buiseness;

import edu.analytics.rop.domain.Bit;
import edu.analytics.rop.domain.Run;
import edu.analytics.rop.domain.Section;
import edu.analytics.rop.domain.Well;
import edu.analytics.rop.repository.BitRepository;
import edu.analytics.rop.repository.RunRepository;
import edu.analytics.rop.repository.SectionRepository;
import edu.analytics.rop.repository.WellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.LinkedList;

@Service
public class WellService {

    @Autowired
    private WellRepository wr;
    @Autowired
    private SectionRepository sr;
    @Autowired
    private RunRepository rr;
    @Autowired
    private BitRepository br;

    @Transactional
    public void testSave() {
        Well well = new Well();
        well.setFieldName("Kovykta");
        well.setPadName("314");
        well.setWellName("3144");
        well.setPadSet("300");
        well.setWellConstruction("Light");
        if (well.getSections() == null) {
            well.setSections(new LinkedList<>());
        }
        wr.save(well);

        Section section = buildSection(well);
        well.getSections().add(section);
        sr.save(section);
        Run run = buildRun(section);
        section.getRuns().add(run);
        rr.save(run);
    }

    private Section buildSection(Well well) {
        Section section = new Section();
        if (section.getRuns() == null) {
            section.setRuns(new LinkedList<>());
        }
        section.setSectionStartDate(LocalDate.of(2020,1,1));
        section.setSectionStartDepth(10);
        section.setSectionEndDepth(40);
        section.setSectionPenetration(section.getSectionEndDepth() - section.getSectionStartDepth());
        section.setSectionDrillingTime(15.2);
        section.setSectionROP(section.getSectionPenetration() / section.getSectionDrillingTime());
        return section;
    }

    private Run buildRun(Section section) {
        Run run = new Run();
        run.setRunNum(1);
        run.setRunStartDate(LocalDate.of(2020,1,1));
        run.setRunStartDepth(10);
        run.setRunEndDepth(40);
        run.setRunPenetration(run.getRunEndDepth() - run.getRunStartDepth());
        run.setRunDrillingTime(15.2);
        run.setRunROP(run.getRunPenetration() / run.getRunDrillingTime());
        run.setRunPurpose("Бурение");

        Bit bit = new Bit();
        bit.setBitSerial("12345");
        bit.setBitShortType("RC");
        bit.setBitFullType("Z1RSJU621");
        bit.setIADCCode("115");
        bit.setDiameter(508.0);
        br.save(bit);

        run.setSection(section);
        run.setBit(bit);
        return run;
    }
}
