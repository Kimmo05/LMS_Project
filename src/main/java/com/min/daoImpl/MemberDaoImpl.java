package com.min.daoImpl;

import java.util.List;
import java.util.Map;

import org.apache.maven.doxia.logging.Log;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.min.dao.IMemberDao;
import com.min.vo.CareerVo;
import com.min.vo.MemberVo;
import com.min.vo.RowNumVo;

import lombok.extern.slf4j.Slf4j;


@Repository
@Slf4j
public class MemberDaoImpl implements IMemberDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.min.daoImpl.MemberDaoImpl.";

	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public MemberVo loginTra(Map<String, Object> map) {
		return  sqlSession.selectOne(NS+"loginTra",map);
	}

	@Override
	public int traSignUp(Map<String, Object> map) {
		log.info("암호화 전 비밀번호 : {}",map.get("pw"));
		String enPassword = passwordEncoder.encode((String)map.get("pw"));
		log.info("암호화 후 비밀번호 : {}",enPassword);
		map.put("pw", enPassword);
			
		return sqlSession.insert(NS+"traSignUp",map);
	}

	@Override
	public MemberVo loginIns(Map<String, Object> map) {
		return sqlSession.selectOne(NS+"loginIns",map);
	}

	@Override
	public int InsSignUp(Map<String, Object> map) {
		log.info("암호화 전 비밀번호 : {}",map.get("pw"));
		String enPassword = passwordEncoder.encode((String)map.get("pw"));
		log.info("암호화 후 비밀번호 : {}",enPassword);
		map.put("pw", enPassword);
		return sqlSession.insert(NS+"InsSignUp",map);
	}

	@Override
	public List<MemberVo> adminUserListRow(RowNumVo rvo) {
		return sqlSession.selectList(NS+"adminUserListRow",rvo);
	}

	@Override
	public int adminUserListTotal() {
		return sqlSession.selectOne(NS+"adminUserListTotal");
	}

	@Override
	public int adminDelTra(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"adminDelTra",map);
	}

	@Override
	public MemberVo findTraId(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"findTraId",map);
	}

	@Override
	public int delTra(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"delTra",map);
	}

	@Override
	public int updateTra(Map<String, Object> map) {
		log.info("암호화 전 비밀번호 : {} ",map.get("pw"));

		String enPassword = passwordEncoder.encode((String)map.get("pw"));
		log.info("암호화 후 비밀번호 : {}",enPassword);
		map.put("pw", enPassword);
		return sqlSession.update(NS+"updateTra",map);
	}

	@Override
	public MemberVo findInsId(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"findInsId",map);
	}

	@Override
	public int delIns(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"delIns",map);
	}

	@Override
	public int updateIns(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"updateIns",map);
	}

	@Override
	public int updateProfile(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"updateProfile",map);
	}
    //회원 아이디 중복
	@Override
	public int checkTraId(String id) {
		
			return sqlSession.selectOne(NS+"checkTraId",id);
	}
	//강사 아이디 중복 
	@Override
	public int checkInsId(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"checkInsId",id);
	}

	//경력 등록
	@Override
	public int insertCar(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NS+"insertCar",map);
	}
	//경력 업데이트
	@Override
	public int insCarUpdate(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"insCarUpdate",map);
	}

	//강사 경력 등록 후 회원상태변경
	@Override
	public int updateCar(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"updateCar",map);
	}

	//경력 상태변경
	@Override
	public int updateCarDelflag(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"updateCarDelflag",map);
	}

	@Override
	public CareerVo loginCar(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"LoginCar",map);
	}

	@Override
	public int checkTraEmail(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"checkTraEmail",id);
	}

	@Override
	public int checkInsEmail(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"checkInsEmail",id);
	}

	@Override
	public MemberVo findTraPw(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"findTraPw",map);
	}

	@Override
	public int updateTraPw(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"updateTraPw",map);
	}

	@Override
	public MemberVo findInsPw(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"findInsPw",map);
	}

	@Override
	public int updateInsPw(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"updateInsPw",map);
	}

	@Override
	public List<MemberVo> adminInsListRow(RowNumVo rvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS+"adminInsListRow",rvo);
	}

	@Override
	public int adminInsListTotal() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"adminInsListTotal");
	}

	
	@Override
	public boolean changeIns(Map<String, Object> map) {
		return (sqlSession.update(NS+"changeIns", map)) > 0 ? true : false; 
	}

}
