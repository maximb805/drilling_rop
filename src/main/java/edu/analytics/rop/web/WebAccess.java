package edu.analytics.rop.web;

import edu.analytics.rop.services.WellServiceAdd;
import edu.analytics.rop.services.WellServiceGet;
import edu.analytics.rop.entities.Well;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/wells")
public class WebAccess {

    @Autowired
    WellServiceGet wellServiceGet;

    @Autowired
    WellServiceAdd wellServiceAdd;

    @GetMapping()
    public String getWells(Model model) {
        model.addAttribute("wells", wellServiceGet.getWells());
        return "wells";
    }

    @PostMapping(value = "/new", produces = {"application/json"}, consumes = {"application/json"})
    public String postWell(@RequestBody List<Well> wells, Model model) {
        Well well1 = wellServiceAdd.addWell(wells);
        model.addAttribute("well", well1);
        return "new";
    }

    @GetMapping("/{id}/sections")
    public String getWells(Model model, @PathVariable("id") int id) {
        model.addAttribute("sections", wellServiceGet.getSections(id));
        return "sections";
    }

    @GetMapping("/{wid}/sections/{sid}/runs")
    public String getRuns(Model model, @PathVariable("wid") int wid, @PathVariable("sid") int sid) {
        model.addAttribute("runs", wellServiceGet.getRuns(sid));
        return "runs";
    }
}
