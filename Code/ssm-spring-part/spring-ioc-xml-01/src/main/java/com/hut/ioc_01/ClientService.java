package com.hut.ioc_01;

/**
 * 静态工厂
 */
public class ClientService {
  private static ClientService clientService = new ClientService();
  private ClientService() {}

  public static ClientService createInstance() {
    return clientService;
  }
}