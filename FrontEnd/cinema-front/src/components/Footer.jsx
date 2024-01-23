import NewsLetterSignup from "./NewsLetterSignup.jsx";

import classes from "./Footer.module.css";
import logo from "../assets/cinemax-logo.png";
import { LiaPhoneSolid } from "react-icons/lia";
import { CiMail } from "react-icons/ci";
import { SiGooglemaps } from "react-icons/si";

export default function Footer() {
  return (
    <div className={classes.footer}>
      <div>
        <img src={logo} alt="Cinema Logo Image" className={classes.logo} />
        <div>
          <SiGooglemaps style={{ fontSize: "24px" }} />
          <span>Some Address 12, Novi Sad</span>
        </div>
        <div>
          <LiaPhoneSolid style={{ fontSize: "24px" }} />
          <span>Tel: +381 021 111 111</span>
        </div>
        <div>
          <CiMail style={{ fontSize: "24px" }} />
          <span>cinemaxbalkan@gmail.com</span>
        </div>
      </div>
      <div className={classes.newsletterContainer}>
        <span>
          Sign up to our Newsletter to get the latest news and special offers
        </span>
        <NewsLetterSignup />
      </div>
      <div>TO DO: add sample text</div>
    </div>
  );
}
