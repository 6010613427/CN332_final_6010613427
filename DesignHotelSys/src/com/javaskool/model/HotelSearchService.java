package com.javaskool.model;

import java.util.LinkedList;
import java.util.List;

public class HotelSearchService {
	private List<Room> rooms; 
	public HotelSearchService() {
	// TODO Auto-generated constructor stub
		rooms=new LinkedList<Room>();
	}
	public void addRoom(Room room){
		rooms.add(room);
	}
	public List<Room> search(RoomType rt){
		List<Room> searchList=new LinkedList<Room>();
		for(Room r:rooms)
			if(r.isVacant()&& r.getType().equals(rt))
				searchList.add(r);
		return searchList;
	}
	public void reserve(int rno){
		for(Room r:rooms){
			if(r.getRno()==rno)
			{
				r.setVacant(false);
				return;
			}
		}
	}
}
