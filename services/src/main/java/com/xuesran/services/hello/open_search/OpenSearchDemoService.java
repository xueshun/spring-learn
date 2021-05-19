package com.xuesran.services.hello.open_search;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.opensearch.DocumentClient;
import com.aliyun.opensearch.OpenSearchClient;
import com.aliyun.opensearch.SearcherClient;
import com.aliyun.opensearch.sdk.dependencies.com.google.common.collect.Lists;
import com.aliyun.opensearch.sdk.generated.commons.OpenSearchClientException;
import com.aliyun.opensearch.sdk.generated.commons.OpenSearchException;
import com.aliyun.opensearch.sdk.generated.commons.OpenSearchResult;
import com.aliyun.opensearch.sdk.generated.search.*;
import com.aliyun.opensearch.sdk.generated.search.general.SearchResult;
import com.xuesran.services.hello.common.utils.JsonUtil;
import com.xuesran.strategy.PriceDto;
import com.xuesran.strategy.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Open search demo service.
 *
 * @author xueshun
 */
@Slf4j
@Service
public class OpenSearchDemoService {

    private final DocumentClient documentClient;
    private final OpenSearchClient openSearchClient;
    private static final String APP_NAME = "xuesran";
    private static final String TABLE_NAME_DEMO = "product_1";
    private static final String TABLE_NAME_SPU = "price_detail_1";


    @Autowired
    public OpenSearchDemoService(DocumentClient documentClient, OpenSearchClient openSearchClient) {
        this.documentClient = documentClient;
        this.openSearchClient = openSearchClient;
    }

    public void put(Integer id) {
        addProduct();
        addPrice();
    }

    private void addProduct() {
        ProductDto productDto = ProductDto.builder()
                .size("XL")
                .range_age("30-34周岁")
                .id(383)
                .type("灯笼裙")
                .brand("秋水伊人")
                .detail("hello word")
                .build();
        documentClient.add(JsonUtil.json2Map(JsonUtil.obj2Json(productDto)));
        try {
            OpenSearchResult commit = documentClient.commit(APP_NAME, TABLE_NAME_DEMO);
            log.info("add product result: {}", JsonUtil.obj2Json(commit));
        } catch (OpenSearchException e) {
            e.printStackTrace();
        } catch (OpenSearchClientException e) {
            e.printStackTrace();
        }
    }

    private void addPrice(){
        PriceDto priceDto = PriceDto.builder()
                .discount_price(55.055)
                .pid(383)
                .act_price(70.78)
                .sale_price(78.65)
                .build();

        documentClient.add(JsonUtil.json2Map(JsonUtil.obj2Json(priceDto)));
        try {
            OpenSearchResult commit = documentClient.commit(APP_NAME, TABLE_NAME_SPU);
            log.info("add price result: {}", JsonUtil.obj2Json(commit));
        } catch (OpenSearchException e) {
            e.printStackTrace();
        } catch (OpenSearchClientException e) {
            e.printStackTrace();
        }
    }

    public void get(Integer id) throws OpenSearchClientException, OpenSearchException {
        //创建SearcherClient对象，并以OpenSearchClient对象作为构造参数
        SearcherClient searcherClient = new SearcherClient(openSearchClient);
        //定义Config对象，用于设定config子句参数，指定应用名，分页，数据返回格式等等
        Config config = new Config(Lists.newArrayList(APP_NAME));
        config.setStart(0);
        config.setHits(5);
        //设置返回格式为fulljson格式
        config.setSearchFormat(SearchFormat.JSON);
        // 创建参数对象
        SearchParams searchParams = new SearchParams(config);
        // 指定搜索的关键词，这里要指定在哪个索引上搜索，如果不指定的话默认在使用“default”索引（索引字段名称是您在您的数据结构中的“索引字段列表”中对应字段。），若需多个索引组合查询，需要在setQuery处合并，否则若设置多个setQuery子句，则后面的子句会替换前面子句
        String queryId = "id:'" + id + "'";
        searchParams.setQuery(queryId);
        //设置查询过滤条件
        //创建sort对象，并设置二维排序
        Sort sort = new Sort();
        //设置id字段降序
        sort.addToSortFields(new SortField("id", Order.DECREASE));
        //若id相同则以RANK相关性算分升序
        sort.addToSortFields(new SortField("RANK", Order.INCREASE));
        //添加Sort对象参数
        //searchParams.setSort(sort);
        //执行查询语句返回数据对象
        SearchResult searchResult = searcherClient.execute(searchParams);
        //以字符串返回查询数据
        String result = searchResult.getResult();

        log.info("result : {}", JSONObject.toJSON(result).toString());

    }

}
