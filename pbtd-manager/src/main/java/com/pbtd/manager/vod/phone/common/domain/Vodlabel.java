package com.pbtd.manager.vod.phone.common.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class Vodlabel  implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int type;
	private int  level;
	private int sequence;
	private int status;
	private String bz;
	private Date create_time;
	private String create_user;
	private Date update_time;
	private String update_user;
    private String typename;
    private String anothername;
    private String labelPic;
    
}
