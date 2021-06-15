package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Product;

/**
 * productsテーブル用DAO (インターフェース)
 */
public interface ProductDao {
    public List<Product> findAll();

    public List<Product> find(Product product);

    public void insert(Product product);
}
