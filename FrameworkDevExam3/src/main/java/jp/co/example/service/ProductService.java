package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Product;

/**
 * productsテーブル用サービスインターフェース
 */
public interface ProductService {
    public List<Product> findAll();

    public List<Product> find(Product product);

    public void insert(Product product);
}
