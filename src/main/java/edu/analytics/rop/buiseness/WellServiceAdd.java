package edu.analytics.rop.buiseness;

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
            wellRepository.save(w);
            List<Section> sections = w.getSections();

            sections.forEach(s -> {
                s.setWell(w);
                sectionRepository.save(s);
                List<Run> runs = s.getRuns();

                runs.forEach(r -> {
                    r.setSection(s);
                    Bit bit = bitRepository.findAll().stream()
                            .filter(b -> b.equals(r.getBit())).findAny().orElse(null);
                    if (bit == null)
                        bitRepository.save(r.getBit());
                    else
                        r.setBit(bit);
                    runRepository.save(r);
                });
            });
        });

//        for (int w = 0; w < wells.size(); w++) {
//            Well well = wells.get(w);
//            wellRepository.save(well);
//            List<Section> sections = well.getSections();
//
//            for (int s = 0; s < sections.size(); s++) {
//                Section section = sections.get(s);
//                section.setWell(well);
//                sectionRepository.save(section);
//                List<Run> runs = section.getRuns();
//
//                for (int r = 0; r < runs.size(); r++) {
//                    Run run = runs.get(r);
//                    run.setSection(section);
//                    Bit bit = run.getBit();
//                    bitRepository.save(bit);
//                    runRepository.save(run);
//                }
//            }
//        }
        return wells.get(wells.size()-1);
    }
}
