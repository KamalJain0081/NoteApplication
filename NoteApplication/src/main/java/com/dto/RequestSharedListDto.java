package com.dto;

public class RequestSharedListDto {
	
	private Long noteId;
	private Integer[] sharedWith;
	
	public Long getNoteId() {
		return noteId;
	}
	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}
	public Integer[] getSharedWith() {
		return sharedWith;
	}
	public void setSharedWith(Integer[] sharedWith) {
		this.sharedWith = sharedWith;
	}
	
	
}
