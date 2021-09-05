/*
 * 
 * Copyright 2014 Jules White
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.magnum.dataup;

/**
 * You will need to create one or more Spring controllers to fulfill the
 * requirements of the assignment. If you use this file, please rename it
 * to something other than "AnEmptyController"
 * 
 * 
	 ________  ________  ________  ________          ___       ___  ___  ________  ___  __       
	|\   ____\|\   __  \|\   __  \|\   ___ \        |\  \     |\  \|\  \|\   ____\|\  \|\  \     
	\ \  \___|\ \  \|\  \ \  \|\  \ \  \_|\ \       \ \  \    \ \  \\\  \ \  \___|\ \  \/  /|_   
	 \ \  \  __\ \  \\\  \ \  \\\  \ \  \ \\ \       \ \  \    \ \  \\\  \ \  \    \ \   ___  \  
	  \ \  \|\  \ \  \\\  \ \  \\\  \ \  \_\\ \       \ \  \____\ \  \\\  \ \  \____\ \  \\ \  \ 
	   \ \_______\ \_______\ \_______\ \_______\       \ \_______\ \_______\ \_______\ \__\\ \__\
	    \|_______|\|_______|\|_______|\|_______|        \|_______|\|_______|\|_______|\|__| \|__|
                                                                                                                                                                                                                                                                    
 * 
 */

import java.util.Collection;

import org.magnum.config.PropertiesUtility;
import org.magnum.dataup.model.Video;
import org.magnum.repository.VideoRepository;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.common.collect.Lists;

import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Streaming;

import org.springframework.beans.factory.annotation.Autowired;



@Controller
public class VideoFilesController {

	@Autowired
	PropertiesUtility propertiesUtility;
	
	@Autowired
	private VideoRepository repository;

	@RequestMapping(value=VideoSvcApi.VIDEO_SVC_PATH, method=RequestMethod.GET)
	public @ResponseBody Collection<Video> getVideoList(){
		return Lists.newArrayList(repository.findAll());
	}
	
	@RequestMapping(value=VideoSvcApi.VIDEO_SVC_PATH, method=RequestMethod.POST)
	public @ResponseBody boolean addVideo(@RequestBody Video v){
		 repository.save(v);
		 return true;
	}
	
	@Streaming
    @GET(VideoSvcApi.VIDEO_DATA_PATH)
    Response getData(@Path(VideoSvcApi.ID_PARAMETER) long id) {
		return null;
	}
}
