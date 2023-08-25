package com.hut.ioc_01;

/**
 * 实例工厂
 */
public class DefaultServiceLocator {

  private static ClientServiceImpl  clientService = new ClientServiceImpl();

  public ClientServiceImpl createClientServiceInstance() {
    return clientService;
  }
}