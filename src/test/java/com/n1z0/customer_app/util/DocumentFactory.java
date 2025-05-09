package com.n1z0.customer_app.util;

import com.n1z0.customer_app.domain.model.Document;

public class DocumentFactory{
    public Document createCnpj(){
        return new Document("68.925.985/0001-08");
    }
    public Document createCpf(){
        return new Document("603.007.280-34");
    }
}
