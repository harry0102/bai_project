package com.pbtd.manager.live.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class LivePackageMQ implements Serializable{
	private static final long serialVersionUID = 1L;
	
    private Integer packageid;

    private String packagename;

    private String chncode;

    private String packageposter;

}