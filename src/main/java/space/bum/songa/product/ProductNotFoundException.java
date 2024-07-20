package space.bum.songa.product;

public class ProductNotFoundException extends Exception {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public ProductNotFoundException(String exceptionMessage) {
    super(exceptionMessage);
  }
}
