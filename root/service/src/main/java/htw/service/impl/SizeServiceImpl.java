package htw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import htw.dao.model.Size;
import htw.dao.repository.SizeRepository;
import htw.service.SizeService;

@Service
public class SizeServiceImpl implements SizeService {

	@Autowired
	private SizeRepository sizeRepository;
	
	@Override
	public Size save(Size size) {
		return this.sizeRepository.save(size);
	}

	@Override
	public Size findById(String size) {
		return this.sizeRepository.findById(size).get();
	}

	@Override
	public List<Size> findAll() {
		return this.sizeRepository.findAll();
	}

}
