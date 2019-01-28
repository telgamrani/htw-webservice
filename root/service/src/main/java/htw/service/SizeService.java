package htw.service;

import java.util.List;

import htw.dao.model.Size;

public interface SizeService {

	Size save(Size size);
	Size findById(String size);
	List<Size> findAll();
}
