package edu.analytics.rop.services;

import edu.analytics.rop.entities.Bit;
import edu.analytics.rop.entities.Run;
import edu.analytics.rop.entities.Section;
import edu.analytics.rop.entities.Well;
import edu.analytics.rop.repository.BitRepository;
import edu.analytics.rop.repository.RunRepository;
import edu.analytics.rop.repository.SectionRepository;
import edu.analytics.rop.repository.WellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


@Service
public class WellServiceAdd {

    @Autowired
    private WellRepository wellRepository;
    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private RunRepository runRepository;
    @Autowired
    private BitRepository bitRepository;

    @Transactional
    public Well addWell(List<Well> wells) {
        wells.forEach(w -> {
            Well well = wellRepository.findAll().stream()
                            .filter(well1 -> well1.equals(w)).findAny().orElse(null);
            if (well == null)
                wellRepository.save(w);
            List<Section> sections = w.getSections();

            sections.forEach(s -> {
                s.setWell(Objects.requireNonNullElse(well, w));

                Section section = sectionRepository.findAll().stream()
                        .filter(sec -> sec.equals(s)).findAny().orElse(null);
                if (section == null)
                    sectionRepository.save(s);
                List<Run> runs = s.getRuns();

                runs.forEach(r -> {
                    r.setSection(Objects.requireNonNullElse(section, s));
                    Bit bit = bitRepository.findAll().stream()
                            .filter(b -> b.equals(r.getBit())).findAny().orElse(null);
                    if (bit == null)
                        bitRepository.save(r.getBit());
                    else
                        r.setBit(bit);
                    Run run = runRepository.findAll().stream()
                            .filter(r1 -> r1.equals(r)).findAny().orElse(null);
                    if (run == null)
                        runRepository.save(r);
                });
            });
        });
        return wells.get(wells.size()-1);
    }

    public void aaa() {
        System.out.println("sss");
    }
}
