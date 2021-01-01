package com.example.demo.brand;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

	@Autowired
	private BrandRepository brandRepo;

	@Autowired
	private LanguageRepository languageRepo;

//	public Brand saveBand(Brand brand) {
//
//		
//		Brand newbrand = new Brand();
//		newbrand.setOther(brand.getOther());
//
//		newbrand.getLocalizations().addAll(brand.getLocalizations().stream().map(locale -> {
//			Language lang = languageRepo.findById(locale.getLang().getId()).get();
//			BrandLocalization newbrandlocale = new BrandLocalization();
//			newbrandlocale.setLang(lang);
//			newbrandlocale.setBrand(newbrand);
//			newbrandlocale.setName(locale.getName());
//			newbrandlocale.setDescription(locale.getDescription());
//			return newbrandlocale;
//
//		}).collect(Collectors.toList()));
//
//		return brandRepo.save(newbrand);
//	}

	public Brand saveBand(Brand brand) {
		try {
			brand.getLocalizations().forEach(locale -> {
				locale.setLang(languageRepo.findById(locale.getLang().getId())
						.orElseThrow(() -> new RuntimeException("notFound")));
				locale.setBrand(brand);
			});
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
		return brandRepo.save(brand);
	}

}
