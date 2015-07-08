package erps.osu;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class DOMParser {
	
	public void parseXML(String xmlLocation){
		try { 
			System.out.println("5");
			File fXmlFile = new File(xmlLocation);
			System.out.println("6");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			System.out.println("7");
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			System.out.println("8");
			Document doc = dBuilder.parse(fXmlFile);
			System.out.println("9");
			//optional, but recommended
			doc.getDocumentElement().normalize();
			System.out.println("10");
			//Parse Accounts
			NodeList nListAdmin = doc.getElementsByTagName("Admin");
			System.out.println("11");
			for (int temp = 0; temp < nListAdmin.getLength(); temp++) {
				System.out.println("12");
				Node nNode = nListAdmin.item(temp);
				System.out.println("13");
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					System.out.println("14");
					Element eElement = (Element) nNode;
					System.out.println("15");
					String operation = eElement.getElementsByTagName("operation").item(0).getTextContent();
					System.out.println("16");
					switch(operation){
					
					case("Insert"):
						System.out.println("17");
					
						String username = eElement.getElementsByTagName("username").item(0).getTextContent();
						String password = eElement.getElementsByTagName("password").item(0).getTextContent();
						Admin admin = new Admin(username,password);
						AdminGateway adminGatewayInsert = new AdminGateway();
						adminGatewayInsert.insertAdmin(admin);
						break;
					case("Update"):
						
						System.out.println("Update Admin");
					
						String usernameUpdate = eElement.getElementsByTagName("username").item(0).getTextContent();
						String passwordUpdate = eElement.getElementsByTagName("password").item(0).getTextContent();
						int adminIdUpdate = Integer.parseInt(eElement.getElementsByTagName("adminId").item(0).getTextContent());
						Admin update = new Admin(adminIdUpdate,usernameUpdate,passwordUpdate);
						AdminGateway updateGate = new AdminGateway();
						updateGate.updateAdmin(update);
						break;
					case("Delete"):
						System.out.println("Delete Admin");
						AdminGateway adminGatewayDelete = new AdminGateway();
						int adminId = Integer.parseInt(eElement.getElementsByTagName("adminId").item(0).getTextContent());
						//String usernameDelete = eElement.getElementsByTagName("username").item(0).getTextContent();
						//String passwordDelete = eElement.getElementsByTagName("password").item(0).getTextContent();
						Admin delete = new Admin(adminId);
						adminGatewayDelete.deleteAdmin(delete);
						break;
						
					case("Select"):
						AdminGateway select = new AdminGateway();
					System.out.println("18");
						int adminIdSelect = Integer.parseInt(eElement.getElementsByTagName("adminId").item(0).getTextContent());
						//String usernameSelect = eElement.getElementsByTagName("username").item(0).getTextContent();
						//String passwordSelect = eElement.getElementsByTagName("password").item(0).getTextContent();
						Admin selectadmin = new Admin(adminIdSelect);
						select.selectAdminDetails(selectadmin);
						break;
					default:
						System.out.println("Operation Not Found");
					}
				}
			}

		
			NodeList nListConsumer = doc.getElementsByTagName("Consumer");
			for (int temp = 0; temp < nListConsumer.getLength(); temp++) {
				Node nNode = nListConsumer.item(temp); 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String operation = eElement.getElementsByTagName("operation").item(0).getTextContent();
					switch(operation){
					case("Insert"):
				    String username = eElement.getElementsByTagName("username").item(0).getTextContent();
					String password = eElement.getElementsByTagName("password").item(0).getTextContent();
					Consumer Consumer = new Consumer(username,password);
					ConsumerGateway ConsumerGatewayInsert = new ConsumerGateway();
					ConsumerGatewayInsert.insertConsumer(Consumer);
					break;
					case("Update"):
						System.out.println("Update Consumer");
						String usernameUpdate = eElement.getElementsByTagName("username").item(0).getTextContent();
						String passwordUpdate = eElement.getElementsByTagName("password").item(0).getTextContent();
						int ConsumerIdUpdate = Integer.parseInt(eElement.getElementsByTagName("ConsumerId").item(0).getTextContent());
						Consumer update = new Consumer(ConsumerIdUpdate,usernameUpdate,passwordUpdate);
						ConsumerGateway updateGate = new ConsumerGateway();
						updateGate.updateConsumer(update);
						break;
					case("Delete"):
						System.out.println("Delete Consumer");
						ConsumerGateway ConsumerGatewayDelete = new ConsumerGateway();
						int ConsumerId = Integer.parseInt(eElement.getElementsByTagName("ConsumerId").item(0).getTextContent());
						//String usernameDelete = eElement.getElementsByTagName("username").item(0).getTextContent();
						//String passwordDelete = eElement.getElementsByTagName("password").item(0).getTextContent();
						Consumer delete = new Consumer(ConsumerId);
						ConsumerGatewayDelete.deleteConsumer(delete);
						break;
						
					case("Select"):
						ConsumerGateway select = new ConsumerGateway();
						int ConsumerIdSelect = Integer.parseInt(eElement.getElementsByTagName("ConsumerId").item(0).getTextContent());
						//String usernameSelect = eElement.getElementsByTagName("username").item(0).getTextContent();
						//String passwordSelect = eElement.getElementsByTagName("password").item(0).getTextContent();
						Consumer selectConsumer = new Consumer(ConsumerIdSelect);
						select.selectConsumerDetails(selectConsumer);
						break;
					default:
						System.out.println("Operation Not Found");
				
					}
				}
			}
			
			
			NodeList nListProducer = doc.getElementsByTagName("Producer");
			for (int temp = 0; temp < nListProducer.getLength(); temp++) {
				Node nNode = nListProducer.item(temp); 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					String operation = eElement.getElementsByTagName("operation").item(0).getTextContent();
					switch(operation){
					case("Insert"):
				    String username = eElement.getElementsByTagName("username").item(0).getTextContent();
					String password = eElement.getElementsByTagName("password").item(0).getTextContent();
					Producer Producer = new Producer(username,password);
					ProducerGateway ProducerGatewayInsert = new ProducerGateway();
					ProducerGatewayInsert.insertProducer(Producer);
					break;
					case("Update"):
						System.out.println("Update Producer");
						String usernameUpdate = eElement.getElementsByTagName("username").item(0).getTextContent();
						String passwordUpdate = eElement.getElementsByTagName("password").item(0).getTextContent();
						int ProducerIdUpdate = Integer.parseInt(eElement.getElementsByTagName("ProducerId").item(0).getTextContent());
						Producer update = new Producer(ProducerIdUpdate,usernameUpdate,passwordUpdate);
						ProducerGateway updateGate = new ProducerGateway();
						updateGate.updateProducer(update);
						break;
					case("Delete"):
						System.out.println("Delete Producer");
						ProducerGateway ProducerGatewayDelete = new ProducerGateway();
						int ProducerId = Integer.parseInt(eElement.getElementsByTagName("ProducerId").item(0).getTextContent());
						//String usernameDelete = eElement.getElementsByTagName("username").item(0).getTextContent();
						//String passwordDelete = eElement.getElementsByTagName("password").item(0).getTextContent();
						Producer delete = new Producer(ProducerId);
						ProducerGatewayDelete.deleteProducer(delete);
						break;
						
					case("Select"):
						ProducerGateway select = new ProducerGateway();
						int ProducerIdSelect = Integer.parseInt(eElement.getElementsByTagName("ProducerId").item(0).getTextContent());
						//String usernameSelect = eElement.getElementsByTagName("username").item(0).getTextContent();
						//String passwordSelect = eElement.getElementsByTagName("password").item(0).getTextContent();
						Producer selectProducer = new Producer(ProducerIdSelect);
						select.selectProducerDetails(selectProducer);
						break;
					default:
						System.out.println("Operation Not Found");
				
					}
				}
			}
			
			

			NodeList nListOrder = doc.getElementsByTagName("Order");
			System.out.println("56");
			for (int temp = 0; temp < nListOrder.getLength(); temp++) {
				System.out.println("57");
				Node nNode = nListOrder.item(temp);
				System.out.println("58");
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					System.out.println("59");
					Element eElement = (Element) nNode;
					System.out.println("60");
					String operation = eElement.getElementsByTagName("operation").item(0).getTextContent();
					System.out.println("61");
					switch(operation){
					case("Insert"):
				    String orderstatus = eElement.getElementsByTagName("orderstatus").item(0).getTextContent();
					System.out.println("62");
					String orderdate = eElement.getElementsByTagName("orderdate").item(0).getTextContent();
					System.out.println("63");
					int consumerid = Integer.parseInt(eElement.getElementsByTagName("consumerID").item(0).getTextContent());
					System.out.println("64");
					int quantity = Integer.parseInt(eElement.getElementsByTagName("quantity").item(0).getTextContent());
					System.out.println("65");
					Order Order = new Order(quantity,orderdate,orderstatus,consumerid);
					System.out.println("66");
					OrderGateway OrderGatewayInsert = new OrderGateway();
					System.out.println("67");
					OrderGatewayInsert.insertOrder(Order);
					System.out.println("68");
					break;
					case("Update"):
						System.out.println("Update Order");
					System.out.println("70");
					String orderdateupdate = eElement.getElementsByTagName("orderdate").item(0).getTextContent();
					System.out.println("71");
					String orderstatusupdate = eElement.getElementsByTagName("orderstatus").item(0).getTextContent();
					System.out.println("72");
					int orderidupdate = Integer.parseInt(eElement.getElementsByTagName("orderid").item(0).getTextContent());
					System.out.println("73");
					int consumeridupdate = Integer.parseInt(eElement.getElementsByTagName("consumerid").item(0).getTextContent());
					System.out.println("74");
					int quantityupdate = Integer.parseInt(eElement.getElementsByTagName("quantity").item(0).getTextContent());
					System.out.println("75");
						Order update = new Order(orderidupdate,quantityupdate,orderstatusupdate,orderdateupdate,consumeridupdate);
						System.out.println("76");
						OrderGateway updateGate = new OrderGateway();
						System.out.println("77");
						updateGate.updateOrder(update);
						System.out.println("78");
						break;
					case("Delete"):
						System.out.println("Delete Order");
					System.out.println("79");
						OrderGateway OrderGatewayDelete = new OrderGateway();
						System.out.println("80");
						String orderdatedel = eElement.getElementsByTagName("orderdate").item(0).getTextContent();
						System.out.println("81");
						String orderstatusdel = eElement.getElementsByTagName("orderstatus").item(0).getTextContent();
						System.out.println("82");
						int orderiddel = Integer.parseInt(eElement.getElementsByTagName("orderid").item(0).getTextContent());
						System.out.println("83");
						int consumeriddel = Integer.parseInt(eElement.getElementsByTagName("consumerid").item(0).getTextContent());
						System.out.println("84");
						int quantitydel = Integer.parseInt(eElement.getElementsByTagName("quantity").item(0).getTextContent());
						System.out.println("85");
						Order delete = new Order(orderiddel,quantitydel,orderstatusdel,orderdatedel,consumeriddel);
						System.out.println("86");
						OrderGatewayDelete.deleteOrder(delete);
						System.out.println("87");
						break;
						
					case("Select"):
						OrderGateway select = new OrderGateway();
					System.out.println("88");
					String orderdatesel = eElement.getElementsByTagName("orderdate").item(0).getTextContent();
					System.out.println("89");
					String orderstatussel = eElement.getElementsByTagName("orderstatus").item(0).getTextContent();
					System.out.println("90");
					int orderidsel = Integer.parseInt(eElement.getElementsByTagName("orderid").item(0).getTextContent());
					System.out.println("91");
					int consumeridsel = Integer.parseInt(eElement.getElementsByTagName("consumerid").item(0).getTextContent());
					System.out.println("92");
					int quantitysel = Integer.parseInt(eElement.getElementsByTagName("quantity").item(0).getTextContent());
					System.out.println("93");
						Order selectOrder = new Order(orderidsel,quantitysel,orderstatussel,orderdatesel,consumeridsel);
						System.out.println("94");
						select.selectOrderDetails(selectOrder);
						System.out.println("95");
						break;
					default:
						System.out.println("Operation Not Found");
				
					}
				}
			}
			
			
			NodeList nListInventory = doc.getElementsByTagName("Inventory");
			System.out.println("140");
			for (int temp = 0; temp < nListInventory.getLength(); temp++) {
				System.out.println("141");
				Node nNode = nListInventory.item(temp);
				System.out.println("142");
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					System.out.println("143");
					Element eElement = (Element) nNode;
					System.out.println("144");
					String operation = eElement.getElementsByTagName("operation").item(0).getTextContent();
					System.out.println("145");
					switch(operation){
					case("Insert"):
					int productid = Integer.parseInt(eElement.getElementsByTagName("productID").item(0).getTextContent());
					System.out.println("146");
					int producerid = Integer.parseInt(eElement.getElementsByTagName("producerID").item(0).getTextContent());
					System.out.println("147");
					int iquantity = Integer.parseInt(eElement.getElementsByTagName("iQuantity").item(0).getTextContent());
					System.out.println("148");
					Inventory Inventory = new Inventory(productid,iquantity,producerid);
					System.out.println("149");
					InventoryGateway InventoryGatewayInsert = new InventoryGateway();
					System.out.println("150");
					InventoryGatewayInsert.insertInventory(Inventory);
					System.out.println("151");
					break;
					case("Update"):
						System.out.println("Update Inventory");
					System.out.println("152");
					int productidupdate = Integer.parseInt(eElement.getElementsByTagName("productid").item(0).getTextContent());
					System.out.println("153");
					int produceridupdate = Integer.parseInt(eElement.getElementsByTagName("producerid").item(0).getTextContent());
					System.out.println("154");
					
					int iquantityupdate = Integer.parseInt(eElement.getElementsByTagName("iquantity").item(0).getTextContent());
					System.out.println("155");
						int InventoryIdUpdate = Integer.parseInt(eElement.getElementsByTagName("InventoryId").item(0).getTextContent());
						System.out.println("156");
						Inventory update = new Inventory(InventoryIdUpdate,productidupdate,iquantityupdate,produceridupdate);
						System.out.println("157");
						InventoryGateway updateGate = new InventoryGateway();
						System.out.println("158");
						updateGate.updateInventory(update);
						System.out.println("159");
						break;
					case("Delete"):
						System.out.println("Delete Inventory");
					System.out.println("160");
						InventoryGateway InventoryGatewayDelete = new InventoryGateway();
						System.out.println("161");
						int InventoryId = Integer.parseInt(eElement.getElementsByTagName("InventoryId").item(0).getTextContent());
						System.out.println("162");
						int productiddel = Integer.parseInt(eElement.getElementsByTagName("productid").item(0).getTextContent());
						System.out.println("163");
						int produceriddel = Integer.parseInt(eElement.getElementsByTagName("producerid").item(0).getTextContent());
						System.out.println("164");
						int iquantitydel = Integer.parseInt(eElement.getElementsByTagName("iquantity").item(0).getTextContent());
						System.out.println("165");
						Inventory delete = new Inventory(InventoryId,productiddel,iquantitydel,produceriddel);
						System.out.println("166");
						InventoryGatewayDelete.deleteInventory(delete);
						System.out.println("167");
						break;
						
					case("Select"):
						InventoryGateway select = new InventoryGateway();
					System.out.println("168");
						int InventoryIdSelect = Integer.parseInt(eElement.getElementsByTagName("InventoryId").item(0).getTextContent());
						System.out.println("169");
						int productidsel = Integer.parseInt(eElement.getElementsByTagName("productid").item(0).getTextContent());
						System.out.println("170");
						int produceridsel = Integer.parseInt(eElement.getElementsByTagName("producerid").item(0).getTextContent());
						System.out.println("171");
						int iquantitysel = Integer.parseInt(eElement.getElementsByTagName("iquantity").item(0).getTextContent());
						System.out.println("172");
						Inventory selectInventory = new Inventory(InventoryIdSelect,productidsel,iquantitysel,produceridsel);
						System.out.println("173");
						select.selectInventoryDetails(selectInventory);
						System.out.println("174");
						break;
					default:
						System.out.println("Operation Not Found");
						System.out.println("175");
				
					}
				}
			}		
			

	    } catch (Exception e) {
		e.printStackTrace();
	    }
	  }
}

