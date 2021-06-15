package jp.co.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.example.controller.form.ProductForm;
import jp.co.example.entity.Product;
import jp.co.example.service.ProductService;

/**
 * コントローラ
 */
@Controller
public class ProductController {

    /**
     * productsテーブル用サービス
     */
    @Autowired
    ProductService productService;

    /**
     * トップ画面表示
     */
    @RequestMapping("/top")
    public String index(@ModelAttribute("product") ProductForm form, Model model) {
        return "top";
    }

    /**
     * 検索結果画面遷移
     */
    @RequestMapping(value = "/execute", params = "search", method = RequestMethod.POST)
    public String search(@ModelAttribute("product") ProductForm form, Model model) {
        Product product = new Product(form.getProductId(), form.getProductName(), form.getPrice());

        List<Product> list = productService.find(product);

        try{list.get(0);

        }catch(RuntimeException e){
        	model.addAttribute("productList",1);
        	return "top";
        }
        model.addAttribute("productList", list);

        return "searchResult";
    }

    /**
     * 登録完了画面遷移
     */
    @RequestMapping(value = "/execute", params = "insert", method = RequestMethod.POST)
    public String insert(@Validated @ModelAttribute("product") ProductForm form,
    		BindingResult bindingResult,Model model) {
    	if(bindingResult.hasErrors()) {
			return "top";
		}

        Product product = new Product(form.getProductId(), form.getProductName(), form.getPrice());

        productService.insert(product);

        return "insertResult";
    }
}
