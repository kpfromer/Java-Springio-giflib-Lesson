package com.teamtreehouse.giflib.controller;

import com.teamtreehouse.giflib.data.GifRepository;
import com.teamtreehouse.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kpfromer on 3/2/17.
 */
@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    public String listGifs(ModelMap modelMap) {
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("gifs", allGifs);
        return "home";
    }

    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap){
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }

    @RequestMapping("/search")
    public String searchGifs(@RequestParam String q, ModelMap modelMap){
        List<Gif> gifs = gifRepository.findAllByName(q);
        modelMap.put("gifs", gifs);
        return "home";
    }

    @RequestMapping("/favorites")
    public String listFavorites(ModelMap modelMap){
        List<Gif> gifs = gifRepository.findByFavorites();
        modelMap.put("gifs", gifs);
        return "favorites";
    }
}
