import React from 'react';
import styles from './News.module.scss';
import BigNewsCard from "../BigNewsCard/BigNewsCard";
import fire from "../../assets/images/fire.png";
import SmallNewsCard from "../SmallNewsCard/SmallNewsCard";
import NavigationMain from "../Navigation/NavigationMain";

const News = () => (
  <div className={styles.news}>
      <aside className={styles.news__navigation}>
          <NavigationMain/>
      </aside>
      <section>
          <div className={styles.news__srollcontainer}>
              <BigNewsCard/>
              <BigNewsCard/>
              <BigNewsCard/>
              <BigNewsCard/>
              <BigNewsCard/>
          </div>
      </section>
      <aside className={styles.news__newsday}>
          <div className={styles.news__newsday__title}>
              <img src={fire} alt="fire"/>
              <p>Новости дня</p>
          </div>
          <SmallNewsCard
              title={"Министр обороны Шойгу обсудил с главой Пентагона Остином ситуацию на Украине"}
              description={"Министр обороны России Сергей Шойгу обсудил по телефону с главой Пентагона Ллойдом Остином..."}/>
          <SmallNewsCard
              title={"Песков заявил, что реальные итоги расследования диверсий на «Северных потоках» удивят ЕС"}
              description={"Главным препятствием для участия России в расследовании диверсий на «Северных потоках»...."}/>
          <SmallNewsCard
              title={"Продавцы из России смогут поставлять товары в Китай через «каналы» Alibaba Group — «Ведомости»"}
              description={"Запустить проект Export to China обещают до конца 2022 года. О каких каналах речь — неизвестно. ..."}/>
          <SmallNewsCard
              title={"Банки в ОАЭ стали чаще проверять источники доходов бизнес-клиентов из России — Bloomberg"}
              description={"При этом официально власти отрицают, что соблюдают санкции США и Великобритании. ..."}/>
          <SmallNewsCard
              title={"ФАС разрешила владельцам Telegram-каналов не указывать заказчиков в рекламных постах"}
              description={"Регулятор также уточнил требования к маркировке рекламы на YouTube.\n" +
                  "\n" +
                  "    В Федеральной антимонопольной службе объяснили, что реклама в Telegram не требует маркировки, сообщает Ассоциация блогеров и агентств, которая обратилась в ведомство с вопросом о том, как правильно маркировать рекламу в мессенджере и на YouTube."}/>
      </aside>
  </div>
);

export default News;
