package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.ProductDao;
import jp.co.example.entity.Product;
import jp.co.example.service.ProductService;

/**
 * productsテーブル用サービス実装クラス
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    /**
     * 全件検索
     */
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    /**
     * 条件を指定した検索
     */
    @Override
    public List<Product> find(Product product) {
        return productDao.find(product);
    }

    /**
     * 登録
     */
    @Override
    public void insert(Product product) {
        productDao.insert(product);
    }
}
