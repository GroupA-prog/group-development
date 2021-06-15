package jp.co.example.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.ProductDao;
import jp.co.example.entity.Product;
import jp.co.example.util.ParamUtil;

/**
 * productsテーブル用DAO
 */
@Repository
public class PgProductDao implements ProductDao {

    private static final String SELECT_ALL = "SELECT * FROM products";
    private static final String SELECT = "SELECT * FROM products WHERE ";
    private static final String ORDER_BY = " ORDER BY product_id";
    private static final String INSERT = "INSERT INTO products (product_name, price) VALUES(:productName, :price)";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Product> findAll() {
        String sql = SELECT_ALL + ORDER_BY;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
    }

    /**
     * 条件を指定した検索
     */
    @Override
    public List<Product> find(Product product) {
        if (product == null || product.isEmptyCondition()) {
            return findAll();
        }

        List<String> condition = new ArrayList<String>();
        MapSqlParameterSource param = new MapSqlParameterSource();

        Integer productId = product.getProductId();
        String productName = product.getProductName();
        Integer price = product.getPrice();

        if (productId != null) {
            condition.add("product_id = :productId");
            param.addValue("productId", productId);
        }

        if (!ParamUtil.isNullOrEmpty(productName)) {
            condition.add("product_name = :productName");
            param.addValue("productName", productName);
        }

        if (price != null) {
            condition.add("price = :price");
            param.addValue("price", price);
        }

        String whereString = String.join(" AND ", condition.toArray(new String[] {}));

        String sql = SELECT + whereString + ORDER_BY;

        return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Product>(Product.class));
    }

    /**
     * 登録
     */
    @Override
    public void insert(Product product) {
        String sql = INSERT;

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("productName", product.getProductName());
        param.addValue("price", product.getPrice());

        jdbcTemplate.update(sql, param);
    }
}
