package interfaces;

public interface IDataSource {
  public String getDataSource();
  public void setDataSource(String dataSource);
}

public interface ITableProducer {
  String[] requestAttributes();
  String[][] requestInstances();
}

public interface IDataSet extends IDataSource, ITableProducer {
}
