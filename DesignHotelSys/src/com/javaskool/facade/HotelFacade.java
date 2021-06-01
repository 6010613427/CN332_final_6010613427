package com.javaskool.facade;
import java.util.List;

import com.javaskool.model.HotelSearchService;
import com.javaskool.model.Room;
import com.javaskool.model.RoomType;

public class HotelFacade {
	HotelSearchService service;
	
	public HotelFacade() {
		super();
		service=new HotelSearchService();
		for(int i=0;i<20;i++)
			if(i%2==0)
				service.addRoom(new Room(i+1,RoomType.SINGLE,true));
			else
				service.addRoom(new Room(i+1,RoomType.DOUBLE,true));		
	}

	public String reserve(RoomType rt){//choice from reception
		List<Room>r=service.search(rt);
		if(r.size()>0)
		{
			
			service.reserve(r.get(0).getRno());
			return "success";
		}
		else
			return "failure";
		
	}
	public String reserve(RoomType rt, int i){//choice from customer
		List<Room>r=service.search(rt);
		if(r.size()>0)
		{
			
			service.reserve(i);//r.get(0).getRno());
			return "success";
		}
		else
			return "failure";
		
	}
	public void displayAvailableRooms(){
		System.out.println(service.search(RoomType.SINGLE));
		System.out.println(service.search(RoomType.DOUBLE));		
	}
}
