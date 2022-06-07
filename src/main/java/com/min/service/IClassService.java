package com.min.service;

import java.util.List;
import java.util.Map;

import com.min.vo.ClassVo;
import com.min.vo.SubjectVo;

public interface IClassService {
	// 과정 전체조회
	public List<ClassVo> classSelectAll();
	// 과정 구분조회
	public List<ClassVo> classSelected();
	// 과정 상세조회
	public ClassVo classSelectDetail(String vo);
	// 과정 등록 폼 생성
	public int classFormInsert(Map<String, Object> vo);
	// 과정 과목리스트 생성
	public int classSubjectInsert(Map<String, Object> vo);
	// 과정 수정
	public int classUpdate(Map<String, Object> vo);
	
	
	
	// 과목 리스트 뽑기(임시)
	public List<SubjectVo> subjectSelected();
}