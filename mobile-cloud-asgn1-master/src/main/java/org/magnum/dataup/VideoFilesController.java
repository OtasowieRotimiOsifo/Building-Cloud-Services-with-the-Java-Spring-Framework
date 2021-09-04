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

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.magnum.config.PropertiesUtility;
import org.magnum.dataup.model.Video;
import org.magnum.dataup.model.VideoStatus;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.beans.factory.annotation.Autowired;

import retrofit.client.Response;
import retrofit.mime.TypedFile;


@Controller
public class VideoFilesController  implements HandlerExceptionResolver,  VideoSvcApi {

	@Autowired
	PropertiesUtility propertiesUtility;
	
	VideoFileManager videoFileManager = VideoFileManager.get();
	
	public VideoFilesController() throws IOException {}
	
	@Override
	public ModelAndView resolveException( //Baeldung
	  HttpServletRequest request,
	  HttpServletResponse response, 
	  Object object,
	  Exception exc) {   
	     
	    ModelAndView modelAndView = new ModelAndView("result");
	    String max_size = propertiesUtility.getProperty("spring.servlet.multipart.max-request-size");
	    if (exc instanceof MaxUploadSizeExceededException) {
	        modelAndView.getModel().put("uploadError", "File size exceeds limit configure limit of: " + max_size);
	    }
	    return modelAndView;
	}

	@Override
	public Collection<Video> getVideoList() {
		
		return null; //videoFileManager.;
	}

	@Override
	public Video addVideo(Video v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VideoStatus setVideoData(long id, TypedFile videoData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getData(long id) {
		// TODO Auto-generated method stub
		return null;
	}

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
	
}
