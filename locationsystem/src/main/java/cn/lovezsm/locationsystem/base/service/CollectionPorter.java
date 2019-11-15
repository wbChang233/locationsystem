package cn.lovezsm.locationsystem.base.service;

import cn.lovezsm.locationsystem.base.bean.Message;
import cn.lovezsm.locationsystem.base.data.CollectionInfoCache;
import cn.lovezsm.locationsystem.base.util.DataParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CollectionPorter extends Porter<String> {
    @Autowired
    CollectionInfoCache cache;

    public CollectionPorter() {
        super("CollectionPorter");
    }

    public CollectionPorter(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void port(String rawData) {
        List<Message> messages = DataParser.parseRawData(rawData);
        cache.putAll(messages);
    }
}