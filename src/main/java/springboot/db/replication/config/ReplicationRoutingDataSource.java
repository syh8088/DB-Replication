package springboot.db.replication.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import springboot.db.replication.util.CircularList;

import java.util.Map;
import java.util.stream.Collectors;

public class ReplicationRoutingDataSource extends AbstractRoutingDataSource {

    private CircularList<String> dataSourceNameList;

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);

        dataSourceNameList = new CircularList<>(
                targetDataSources.keySet()
                        .stream()
                        .filter(key -> key.toString().contains("slave"))
                        .map(key -> key.toString())
                        .collect(Collectors.toList())
        );
    }
    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("currentTransactionName : {}  = " +  TransactionSynchronizationManager.getCurrentTransactionName());
        boolean isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
        if(isReadOnly) {
            return dataSourceNameList.getOne();
        } else {
            return "master";
        }
    }
}
