package net.adsmanager.controller;

import net.adsmanager.model.Ad;
import net.adsmanager.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AdController {
    private AdService adService;

    @Autowired(required = true)
    @Qualifier(value = "adService")
    public void setAdService(AdService adService){ this.adService=adService; }

    @RequestMapping(value = "ads", method = RequestMethod.GET)
    public String listAds(Model model){
        model.addAttribute("ad", new Ad());
        model.addAttribute("listAds", this.adService.listAds());

        return "ads";
    }

    @RequestMapping(value = "/ads/add", method = RequestMethod.POST)
    public String addAd(@ModelAttribute("add") Ad ad){
        if(ad.getId() == 0){
            this.adService.addAd(ad);
        }else {
            this.adService.updateAd(ad);
        }

        return "redirect:/ads";
    }

    @RequestMapping("/remove/{id}")
    public String removeAd(@PathVariable("id") int id){
        this.adService.removeAd(id);

        return "redirect:/ads";
    }


    @RequestMapping("/edit/{id}")
    public String editAd(@PathVariable("id") int id, Model model){
        model.addAttribute("ad", this.adService.getAdById(id));
        model.addAttribute("listAds", this.adService.listAds());

        return "ads";
    }

    @RequestMapping("/addata/{id}")
    public String adData(@PathVariable("id") int id, Model model){
        model.addAttribute("ad",this.adService.getAdById(id));

        return "addata";
    }


}
