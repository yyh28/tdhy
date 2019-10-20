package com.example.tdhy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tdhy.mapper.extend.InProductMapperExtends;
import com.example.tdhy.po.InProduct;
import com.example.tdhy.service.InProductService;

@Service
public class InProductServiceImpl implements InProductService {

	@Autowired
	private InProductMapperExtends inProductMapper;

	@Override
	public List<InProduct> getAll() throws Exception {
		return inProductMapper.selectByExample(null);
	}

	@Override
	public int add(InProduct t) throws Exception {
		try {
			inProductMapper.insert(t);
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public int update(InProduct t) throws Exception {
		return inProductMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(Integer id) throws Exception {
		return inProductMapper.deleteByPrimaryKey(id);
	}

	@Override
	public InProduct getById(Integer id) throws Exception {
		return inProductMapper.selectByPrimaryKey(id);
	}

}
