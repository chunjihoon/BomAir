package pack.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import pack.scheduler.AInter;

@Component
public class Scheduler {

	@Autowired
	private AInter inter;

	@Scheduled(cron = "0 0 3 * * *")
	public void DeleteTableADaily() {
		System.out.println("A 작동 시간");
		boolean b = false;
		String tname = "<CURDATE()";
		if (inter.DailyDelete(tname)) {
			System.out.println("테이블 내용 삭제 성공!");
		} else {
			System.out.println("테이블 내용 삭제 실패!");
		}
	}

	@Scheduled(cron = "0 28 9 * * *")
	public void DeleteTableADaily2() {
		System.out.println("B 작동 시간");
		boolean b = false;
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				String sql="delete from ba"+i+"0"+j+" where STR_TO_DATE(substring(t_no,2,8),'%Y%m%d') < CURDATE()";
				String sql2="delete from ba"+i+"0"+j+"a where STR_TO_DATE(substring(t_no,2,8),'%Y%m%d') < CURDATE()";
				String sql3="delete from ba"+i+"0"+j+"b where STR_TO_DATE(substring(t_no,2,8),'%Y%m%d') < CURDATE()";
				String sql4="delete from ba"+i+"0"+j+"c where STR_TO_DATE(substring(t_no,2,8),'%Y%m%d') < CURDATE()";
				String sql5="delete from ba"+i+"0"+j+"d where STR_TO_DATE(substring(t_no,2,8),'%Y%m%d') < CURDATE()";
				inter.DailyDelete2(sql);
				inter.DailyDelete2(sql2);
				inter.DailyDelete2(sql3);
				inter.DailyDelete2(sql4);
				inter.DailyDelete2(sql5);
			}
		}
	}
}

//	@Scheduled(cron = "0 0 0 1/4 * *")
//	public void DeleteTableADaily() {
//		System.out.println("A 작동 시간");
//		boolean b = false;
//		for (int i = 1; i <= 9; i++) {
//			for (int j = 1; j <= 9; j++) {
//				String tname = "<CURDATE()";
//				if (inter.DailyDelete(tname)) {
//					System.out.println(tname + "테이블 내용 삭제 성공!");
//				} else {
//					System.out.println(tname + "테이블 내용 삭제 실패!");
//				}
//			}
//		}
//	}
//
//	@Scheduled(cron = "0 0 0 2/4 * *")
//	public void DeleteTableBDaily() {
//		System.out.println("B 작동 시간");
//		boolean b = false;
//		for (int i = 1; i <= 9; i++) {
//			for (int j = 1; j <= 9; j++) {
//				String tname = "ba" + i + "0" + j + "b";
//				if (inter.DailyDelete(tname)) {
//					System.out.println(tname + "테이블 내용 삭제 성공!");
//				} else {
//					System.out.println(tname + "테이블 내용 삭제 실패!");
//				}
//			}
//		}
//	}
//
//	@Scheduled(cron = "0 0 0 3/4 * *")
//	public void DeleteTableCDaily() {
//		System.out.println("C 작동 시간");
//		boolean b = false;
//		for (int i = 1; i <= 9; i++) {
//			for (int j = 1; j <= 9; j++) {
//				String tname = "ba" + i + "0" + j + "c";
//				if (inter.DailyDelete(tname)) {
//					System.out.println(tname + "테이블 내용 삭제 성공!");
//				} else {
//					System.out.println(tname + "테이블 내용 삭제 실패!");
//				}
//			}
//		}
//	}
//
//	@Scheduled(cron = "0 0 0 4/4 * *")
//	public void DeleteTableDDaily() {
//		System.out.println("D 작동 시간");
//		boolean b = false;
//		for (int i = 1; i <= 9; i++) {
//			for (int j = 1; j <= 9; j++) {
//				String tname = "ba" + i + "0" + j + "d";
//				if (inter.DailyDelete(tname)) {
//					System.out.println(tname + "테이블 내용 삭제 성공!");
//				} else {
//					System.out.println(tname + "테이블 내용 삭제 실패!");
//				}
//			}
//		}
//	}
