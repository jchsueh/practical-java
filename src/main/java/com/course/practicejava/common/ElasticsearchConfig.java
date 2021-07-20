package com.course.practicejava.common;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

    @Override
    public RestHighLevelClient elasticsearchClient() {
        final var clientConfiguration =
                ClientConfiguration.builder().connectedTo("localhost:9200").build();
//        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                .connectedTo("localhost:443")  // set the address of the Elasticsearch cluster
//                .usingSsl(createSSLContext())  // use the SSLContext with the client cert
//                .withBasicAuth("admin", "admin")   // use the headers for authentication
//                .build();
        return RestClients.create(clientConfiguration).rest();
    }

//    private SSLContext createSSLContext() {
//        try {
//            SSLContext sslContext = SSLContext.getInstance("TLS");
//
//            KeyManager[] keyManagers = getKeyManagers();
//
//            sslContext.init(keyManagers, null, null);
//
//            return sslContext;
//        } catch (Exception e) {
//            LOG.error("cannot create SSLContext", e);
//        }
//        return null;
//    }
//
//    private KeyManager[] getKeyManagers()
//            throws KeyStoreException, NoSuchAlgorithmException, IOException, CertificateException, UnrecoverableKeyException {
//        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(CERT_FILE)) {
//            KeyStore clientKeyStore = KeyStore.getInstance("PKCS12");
//            clientKeyStore.load(inputStream, CERT_PASSWORD.toCharArray());
//
//            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
//            kmf.init(clientKeyStore, CERT_PASSWORD.toCharArray());
//            return kmf.getKeyManagers();
//        }
//    }
//
//    @Bean
//    @Primary
//    public ElasticsearchOperations elasticsearchTemplate() {
//        return elasticsearchOperations();
//    }
}
