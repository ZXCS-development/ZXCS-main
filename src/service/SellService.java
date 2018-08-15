package service;

import java.util.ArrayList;
import java.util.HashSet;

import dao.*;
import bean.*;
import bean.orders.*;;

/**
 * ?Ϊ��֤���ݿ����ӹرպ�������Ӧ�ð�new��������ĸ���αȽϺ� Ŀǰdao
 * ���۷���
 * 	ҵ���߼�
 */
public class SellService {
	
	private OrderDao orderdao;
	private GoodsDao goodsdao;

	/**
	 * ?��ô���ݴ����Ĳ�ͬ���Ͷ����Զ��������ص�dao
	 * ?�Ѷ�����Ʒ�����Ķ��insert��������dao���Ƿ���service
	 * ��Ʒ���۷���
	 * 	���� 					���Ӽ�¼
	 * 	����������Ʒ����� 		���Ӽ�¼
	 *  ������				�����¼
	 */
	public void addOrder(SellOrder order, HashSet<Goods> sellGoods) {
		orderdao = new OrderDao();
		GoodsDao goodsdao = new GoodsDao();
		//������Ʒ��ʱ�Ľ��� ��ʱ����Ч������ �����ۼۣ��ۼۿ����뵱ǰ������Ӧ�ա�ʵ�ս���в�ѯ
		for(Goods g:sellGoods) {
			g.setInPrice(goodsdao.getInPriceById(g.getId()));
		}
		orderdao.addOrders(order);	//����ID�������ɵģ��������õ�
		orderdao.addOrderDetails(order.getId(), sellGoods);
		int depotId = order.getDepot().getDid();
		//ѭ������ÿ����Ʒ�Ŀ�� ��Դ�ֿⲻ�䣬�ֿ����Ϊ��
		goodsdao = new GoodsDao();
		for(Goods g:sellGoods) {
			goodsdao.changeGoodsStore(g.getId(), depotId, -g.getTempNum());
		}
	}
	/**
	 * ��Ʒ���۷���(�ֶ����ڣ�
	 * 	���� 					���Ӽ�¼
	 * 	����������Ʒ����� 		���Ӽ�¼
	 *  ������				�����¼
	 *  ��Ա�Ļ���Ա���Ѽ�¼��	���Ӽ�¼		 <<----δ���
	 */
	public void addOrder(SellOrder order, HashSet<Goods> sellGoods, boolean manalDate) {
		orderdao = new OrderDao();
		GoodsDao goodsdao = new GoodsDao();
		//������Ʒ��ʱ�Ľ��� ��ʱ����Ч������ �����ۼۣ��ۼۿ����뵱ǰ������Ӧ�ա�ʵ�ս���в�ѯ
		for(Goods g:sellGoods) {
			g.setInPrice(goodsdao.getInPriceById(g.getId()));
		}
		orderdao.addOrders(order, manalDate);
		orderdao.addOrderDetails(order.getId(), sellGoods);
		int depotId = order.getDepot().getDid();
		//ѭ������ÿ����Ʒ�Ŀ�� ��Դ�ֿⲻ�䣬�ֿ����Ϊ��
		goodsdao = new GoodsDao();
		for(Goods g:sellGoods) {
			goodsdao.changeGoodsStore(g.getId(), depotId, -g.getTempNum());
		}
	}
	/**
	 * ��Ʒ�����˻�����
	 * 	�����˻�ֱ�Ӳ鵽���۵�����Ʒ����ȫ����ArrayList<Goods>����
	 * 	�����˻���ǰ̨ѡ����Ʒ������ArrayList<Goods>�󴫹���
	 */
	public void addOrder(SellOrder_tui order, HashSet<Goods> sellGoods) {
		orderdao = new OrderDao();
		GoodsDao goodsdao = new GoodsDao();
		//������Ʒ��ʱ�Ľ��� ��ʱ����Ч������ �����ۼۣ��ۼۿ����뵱ǰ������Ӧ�ա�ʵ�ս���в�ѯ
		for(Goods g:sellGoods) {
			g.setInPrice(goodsdao.getInPriceById(g.getId()));
		}
		orderdao.addOrders(order);
		//Ϊ�˷��� ��������˵Ļ�����ѭ�����Ӷ�����Ʒ���飬���ᷢ����������
		orderdao.addOrderDetails(order.getId(), sellGoods);
		int depotId = order.getDepot().getDid();
		//ѭ������ÿ����Ʒ�Ŀ�� ȥ��ֿⲻ�䣬�ֿ����Ϊ��
		for(Goods g:sellGoods) {
			new GoodsDao().changeGoodsStore(g.getId(), depotId, g.getTempNum());
		}
	}
}
