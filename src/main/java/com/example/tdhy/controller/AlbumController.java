package com.example.tdhy.controller;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tdhy.po.Album;
import com.example.tdhy.service.AlbumService;

@Controller
@RequestMapping("/admin/album")
public class AlbumController {
	@Autowired
	private AlbumService albumService;

	@RequestMapping("/getAll")
	public String getAll(Model modle) throws Exception {
		List<Album> albums = albumService.getAll();
		modle.addAttribute("albums", albums);
		return "admin/album/select";
	}

	@RequestMapping("/toupload")
	public String toedit(Model model, String id) throws Exception {
		if (id != null && id.length() > 0) {
			Album album = albumService.getById(id);
			model.addAttribute("ablum", album);
		}
		return "/admin/album/edit";
	}

	@RequestMapping("/edit")
	public String edit(Album album) throws Exception {
		String id = album.getId();

		if (id != null && id.length() > 0) {
			albumService.add(album);
		} else {
			ObjectId objectId = new ObjectId();
			album.setId(objectId.toString());
			album.setCreateTime(new Date());
			albumService.add(album);
		}
		return "redirect:getAll";
	}

	@RequestMapping("/delete")
	public String delete(String id) throws Exception {
		if (id != null && id.length() > 0) {
			albumService.delete(id);
		}
		return "redirect:getAll";
	}
}
